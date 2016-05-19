package theunderground.com.ucrmap;

/**
 * Created by Roger on 5/18/2016.
 */
public class ClassRoomQueryBuilder {

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
        return "Classrooms";
    } //changed from users to classrooms

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

    public String createContact(Classroom contact) // change to classroom class and edit for what is needed
    {
        return String.format("{\"Classroom\" : \"%s\", "
                        + "\"Comment1\" : \"%s\", "
                        + "\"Comment2\" : \"%s\", "
                        + "\"Comment3\" : \"%s\", "
                        + "\"Comment4\" : \"%s\", "
                        + "\"Comment5\" : \"%s\", "
                        + "\"Comment6\" : \"%s\", "
                        + "\"Comment7\" : \"%s\", "
                        + "\"Comment8\" : \"%s\", "
                        + "\"Comment9\" : \"%s\", "
                        + "\"Comment10\" : \"%s\"}",
                        contact.Classroom_name, contact.Comment1, contact.Comment2, contact.Comment3, contact.Comment4,
                        contact.Comment5, contact.Comment6, contact.Comment7, contact.Comment8, contact.Comment9,
                        contact.Comment10 );
    }
    public String setUserData(Classroom contact) //copy top
    {
        return String.format("{ \"$set\" : "
                        + "{\"Classroom\" : \"%s\", "
                        + "\"Comment1\" : \"%s\", "
                        + "\"Comment2\" : \"%s\", "
                        + "\"Comment3\" : \"%s\", "
                        + "\"Comment4\" : \"%s\", "
                        + "\"Comment5\" : \"%s\", "
                        + "\"Comment6\" : \"%s\", "
                        + "\"Comment7\" : \"%s\", "
                        + "\"Comment8\" : \"%s\", "
                        + "\"Comment9\" : \"%s\", "
                        + "\"Comment10\" : \"%s\"}}",
                        contact.Classroom_name, contact.Comment1, contact.Comment2, contact.Comment3, contact.Comment4,
                        contact.Comment5, contact.Comment6, contact.Comment7, contact.Comment8, contact.Comment9,
                        contact.Comment10 );
    }
}
