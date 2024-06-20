import org.apache.xml.security.Init;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class XmlSigner {

    static {
        Init.init();
    }

    public static Document signXml(Document doc, PrivateKey privateKey, X509Certificate cert) throws Exception {
        Element rootElement = doc.getDocumentElement();

        XMLSignature signature = new XMLSignature(doc, "", XMLSignature.ALGO_ID_SIGNATURE_RSA);

        rootElement.appendChild(signature.getElement());

        Transforms transforms = new Transforms(doc);
        transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
        transforms.addTransform(Transforms.TRANSFORM_C14N_WITH_COMMENTS);

        signature.addDocument("", transforms, Constants.ALGO_ID_DIGEST_SHA1);
        signature.addKeyInfo(cert);
        signature.addKeyInfo(cert.getPublicKey());

        signature.sign(privateKey);

        return doc;
    }

    public static void main(String[] args) throws Exception {
        // Load the XML document to be signed
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream("nfe.xml"));

        // Load the keystore and get the private key and certificate
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(new FileInputStream("certificado.pfx"), "senha".toCharArray());
        String alias = ks.aliases().nextElement();
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, "senha".toCharArray());
        X509Certificate cert = (X509Certificate) ks.getCertificate(alias);

        // Sign the XML
        Document signedDoc = signXml(doc, privateKey, cert);

        // Output the signed XML
        // ... (transform signedDoc to string or save to file)
    }
}

