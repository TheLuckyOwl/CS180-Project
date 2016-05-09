package theunderground.com.ucrmap;

/**
 * Created by Roger on 5/2/2016.
 */
public class QueryBuilder {
    /**
     * Specify your database name here
     * @return
     */
    public String getDatabaseName() {
        return "ucr_student_tools_db";
    }

    /**
     * Specify your MongoLab API here
     * @return
     */
    public String getApiKey() {
        return "s3RSrHHz5Bem_zGQYv5IAFna1Wurv3bo";
    }

    /**
     * This constructs the URL that allows you to manage your database,
     * collections and documents
     * @return
     */
    public String getBaseUrl()
    {
        return "https://api.mongolab.com/api/1/databases/"+getDatabaseName()+"/collections/";
    }

    /**
     * Completes the formating of your URL and adds your API key at the end
     * @return
     */
    public String docApiKeyUrl()
    {
        return "?apiKey="+getApiKey();
    }

    public String docApiKeyUrl(String docid)
    {
        return "/"+docid+"?apiKey="+getApiKey();
    }


    /**
     * Returns the docs101 collection
     * @return
     */
    public String documentRequest()
    {
        return "Users";
    }

    /**
     * Builds a complete URL using the methods specified above
     * @return
     */
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
    /**
     * Formats the contact details for MongoHQ Posting
     * @param contact: Details of the person
     * @return
     */
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
                        + "\"Time\" : \"%s\"}}",
                        //+ "\"Class2\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class3\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class4\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class5\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class6\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class7\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class8\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class9\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}, "
                        //+ "\"Class10\" : "
                        //+"{\"Data\" : \"%s\", "
                        //+"\"Day\" : \"%s\", "
                        //+ "\"Time\" : \"%s\"}} "
                        contact.First_name, contact.Middle_initial, contact.Last_name, contact.Username, contact.Password,
                        contact.IlearnUser, contact.IlearnPass, contact.getClass1Data(), contact.getClass1Day(), contact.getClass1Time());
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
                + "\"Time\" : \"%s\"}}" + "}",
                //+ "\"Class2\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class3\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class4\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class5\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class6\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class7\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class8\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class9\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}, "
                //+ "\"Class10\" : "
                //+"{\"Data\" : \"%s\", "
                //+"\"Day\" : \"%s\", "
                //+ "\"Time\" : \"%s\"}} "
                contact.First_name, contact.Middle_initial, contact.Last_name, contact.Username, contact.Password,
                contact.IlearnUser, contact.IlearnPass, contact.getClass1Data(), contact.getClass1Day(), contact.getClass1Time());
    }
}
