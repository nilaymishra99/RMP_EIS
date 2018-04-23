//Main Class of execution
package com.dell.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


@WebServlet("/UploadDownloadFileServlet")
public class UploadDownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    private static String[] columns = {"sElementName", "sAttributeName", "sType", "sLength" , "sMapping" , "sNotes"};
    private static List<ExcelBean> rmp =  new ArrayList<>();
	@Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		
		
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
	//Download Uploaded File
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		if(fileName == null || fileName.equals("")){
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
		if(!file.exists()){
			throw new ServletException("File doesn't exists on server.");
		}
		System.out.println("File location on server::"+file.getAbsolutePath());
		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null? mimeType:"application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		ServletOutputStream os       = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read=0;
		while((read = fis.read(bufferData))!= -1){
			os.write(bufferData, 0, read);
		}
		os.flush();
		os.close();
		fis.close();
		System.out.println("File downloaded at client successfully");
	}
	//Upload File
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
		        XMLReader xr = sp.getXMLReader();

		        xr.setContentHandler(new FragmentContentHandler(xr));
		        Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
		        while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				File file = new File(fileItem.getName());
				InputStream inFile=new FileInputStream(fileItem.getName());
				fileItem.write(file);
				out.write("File "+fileItem.getName()+ " uploaded successfully.");
				out.write("<br>");
				out.write("<a href=\"UploadDownloadFileServlet?fileName="+fileItem.getName()+"\">"+fileItem.getName()+"</a>");
				//Generating XPaths from input XML
				xr.parse(new InputSource(inFile));
				rmp.add(new ExcelBean("Rajeev Singh", "rajeev@example.com", 
		                "w", "1200000.0", "V", "M"));

				rmp.add(new ExcelBean("Rajeev Singh", "rajeev@example.com", 
		                "w", "1200000.0", "V", "M"));

				rmp.add(new ExcelBean("Rajeev Singh", "rajeev@example.com", 
		                "w", "1200000.0", "V", "M"));
			}
		} catch (FileUploadException e) {
			out.write("Exception in uploading file.");
		} catch (Exception e) {
			out.write("Exception in uploading file.");
		}
		out.write("</body></html>");
	}

}
