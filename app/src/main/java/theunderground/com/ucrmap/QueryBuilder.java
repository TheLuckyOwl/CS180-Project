package theunderground.com.ucrmap;

/**
 * Created by Roger on 5/2/2016.
 */
public class QueryBuilder {

    public String getDatabaseName() {
        return "ucr_student_tools_db";
    }

    public String getApiKey() {
        return "s3RSrHHz5Bem_zGQYv5IAFna1Wurv3bo";
    }

    public String getBaseUrl()
    {
        return "https://api.mongolab.com/api/1/databases/"+getDatabaseName()+"/collections/";
    }

    public String docApiKeyUrl()
    {
        return "?apiKey="+getApiKey();
    }

    public String docApiKeyUrl(String docid)
    {
        return "/"+docid+"?apiKey="+getApiKey();
    }

    public String documentRequest()
    {
        return "Users";
    }

    public String buildContactsSaveURL()
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl();
    }


    public String buildContactsGetURL()
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl();
    }

    public String buildContactsUpdateURL(String doc_id)
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl(doc_id);
    }

    public String createContact(User contact)
    {
        return String.format("{\"FirstName\" : \"%s\", "
                        + "\"MiddleInitial\" : \"%s\", "
                        + "\"LastName\" : \"%s\", "
                        + "\"UserName\" : \"%s\", "
                        + "\"Password\" : \"%s\", "
                        + "\"ilearnUser\" : \"%s\", "
                        + "\"ilearnPass\" : \"%s\", "
                        + "\"Class1\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"} ,"
                        + "\"Class2\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class3\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class4\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class5\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class6\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class7\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class8\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class9\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}, "
                        + "\"Class10\" : "
                        +"{\"Data\" : \"%s\", "
                        +"\"Day\" : \"%s\", "
                        + "\"Time\" : \"%s\"}}",
                        contact.First_name, contact.Middle_initial, contact.Last_name, contact.Username, contact.Password,
                        contact.IlearnUser, contact.IlearnPass,
                        contact.getClass1Data(), contact.getClass1Day(), contact.getClass1Time(),
                        contact.getClass2Data(), contact.getClass2Day(), contact.getClass2Time(),
                        contact.getClass3Data(), contact.getClass3Day(), contact.getClass3Time(),
                        contact.getClass4Data(), contact.getClass4Day(), contact.getClass4Time(),
                        contact.getClass5Data(), contact.getClass5Day(), contact.getClass5Time(),
                        contact.getClass6Data(), contact.getClass6Day(), contact.getClass6Time(),
                        contact.getClass7Data(), contact.getClass7Day(), contact.getClass7Time(),
                        contact.getClass8Data(), contact.getClass8Day(), contact.getClass8Time(),
                        contact.getClass9Data(), contact.getClass9Day(), contact.getClass9Time(),
                        contact.getClass10Data(), contact.getClass10Day(), contact.getClass10Time());
    }
    public String setUserData(User contact)
    {
        return String.format("{ \"$set\" : "
                + "{\"FirstName\" : \"%s\", "
                + "\"MiddleInitial\" : \"%s\", "
                + "\"LastName\" : \"%s\", "
                + "\"UserName\" : \"%s\", "
                + "\"Password\" : \"%s\", "
                + "\"ilearnUser\" : \"%s\", "
                + "\"ilearnPass\" : \"%s\", "
                + "\"Class1\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class2\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class3\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class4\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class5\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class6\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class7\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class8\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class9\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}, "
                + "\"Class10\" : "
                +"{\"Data\" : \"%s\", "
                +"\"Day\" : \"%s\", "
                + "\"Time\" : \"%s\"}}" + "}",
                contact.First_name, contact.Middle_initial, contact.Last_name, contact.Username, contact.Password,
                contact.IlearnUser, contact.IlearnPass,
                contact.getClass1Data(), contact.getClass1Day(), contact.getClass1Time(),
                contact.getClass2Data(), contact.getClass2Day(), contact.getClass2Time(),
                contact.getClass3Data(), contact.getClass3Day(), contact.getClass3Time(),
                contact.getClass4Data(), contact.getClass4Day(), contact.getClass4Time(),
                contact.getClass5Data(), contact.getClass5Day(), contact.getClass5Time(),
                contact.getClass6Data(), contact.getClass6Day(), contact.getClass6Time(),
                contact.getClass7Data(), contact.getClass7Day(), contact.getClass7Time(),
                contact.getClass8Data(), contact.getClass8Day(), contact.getClass8Time(),
                contact.getClass9Data(), contact.getClass9Day(), contact.getClass9Time(),
                contact.getClass10Data(), contact.getClass10Day(), contact.getClass10Time());
    }
}
