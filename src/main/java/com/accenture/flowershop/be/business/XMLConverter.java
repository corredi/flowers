package com.accenture.flowershop.be.business;

import org.exolab.castor.dsml.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Service
public class XMLConverter {
    @Autowired
    private Marshaller marshaller;
    @Autowired
    private Unmarshaller unmarshaller;


    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void convertFromObjectToXML(Object object, String filepath) throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(filepath);
            getMarshaller().marshal(object, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    public String convertFromObjectToXMLString(Object object) throws IOException {
        StringWriter output = new StringWriter();
        try {
            getMarshaller().marshal(object, new StreamResult(output));
        } finally {
            if (output != null) {
                output.close();
            }
        }
        return output.toString();
    }

    public Object convertFromXMLToObject(String xmlfile) throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(xmlfile);
            //System.out.println(is);
            return getUnmarshaller().unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public Object convertFromStringToObject(String string) throws IOException {
        StringReader reader = new StringReader(string);
        try {
            return getUnmarshaller().unmarshal(new StreamSource(reader));
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
