import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class NFeSender {

    private static final String NAMESPACE = "http://www.portalfiscal.inf.br/nfe";
    private static final String URL = "https://nfe.sefazvirtual.rs.gov.br/ws/NfeAutorizacao/NfeAutorizacao4.asmx";
    private static final String METHOD_NAME = "nfeAutorizacaoLote";
    private static final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

    public void sendNFe(String signedXml) {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("nfeDadosMsg", signedXml);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(URL);

        try {
            httpTransport.call(SOAP_ACTION, envelope);
            SoapObject response = (SoapObject) envelope.getResponse();
            // Process the response
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

