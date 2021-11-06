package constants;
import jdbs.GetToken;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@Getter
@UtilityClass
public class Constants {

   private static GetToken token = new GetToken();

    //domain name
    @UtilityClass
    public static class ServerName{
        public final String TRELLO_API_SERVER = "https://api.trello.com/";
    }

    //path
    @UtilityClass
    public static class Path{
        public final String TRELLO_API_PATH = "1/";
    }

    //endpoint
    @UtilityClass
    public static class EndPoint{
        public static final String TRELLO_ENDPOINT_CREATE_A_BOARD = "boards";
        public static final String TRELLO_ENDPOINT_CREATE_A_LIST = "lists";
        public static final String TRELLO_ENDPOINT_CREATE_A_CARD = "cards";
        public static final String TRELLO_ENDPOINT_CREATE_ATTACHMENT = "/attachments";
        public static final String TRELLO_ENDPOINT_CREATE_A_CHECKLIST = "checklists";
        public static final String TRELLO_ENDPOINT_CREATE_A_CHECKITEMS = "/checkItems";
        public static final String TRELLO_ENDPOINT_ARCHIVE_A_LIST = "lists/{id}/closed";
        public static final String TRELLO_ENDPOINT_UPDATE_CHECKITEM = "cards/{id}/checkItem/{idCheckItem}";
        public static final String TRELLO_ENDPOINT_ADD_ACTION = "cards/{id}/actions/comments";
    }

    public static final String TRELLO_API_KEY = token.trelloApiKey();
    public static final String TRELLO_API_TOKEN = token.trelloApiToken();
}
