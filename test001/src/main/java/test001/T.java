package test001;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

public class T {
	
	/**
     * 获取license 456 
     * 
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = new FileInputStream(new File("E:/zhangxin/ijm/test001/license.xml"));
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        // 验证License
        if (!getLicense()) {
            return;
        }

        try {
            Document doc = new Document("E:/zhangxin/ijm/test.doc");
			doc.updateFields();
			doc.save("E:/zhangxin/ijm/test223344.doc");
            
			File file = new File("E:/zhangxin/ijm/test.pdf");
			FileOutputStream os = new FileOutputStream(file);
            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
