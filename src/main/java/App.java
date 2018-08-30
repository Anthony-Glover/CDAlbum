import com.qa.business.CDServiceImpl;
import com.qa.interoperability.CDEndPoint;
import com.qa.persistence.repository.CDDBRepository;

public class App {

	public static void main(String[] args) 
	{
		CDEndPoint interop = new CDEndPoint();
		CDServiceImpl service = new CDServiceImpl();
		interop.setService(service);
		CDDBRepository repo = new CDDBRepository();
		service.setRepo(repo);
		
		interop.addCD("{\"title\":\"Ms\",\"artists\": [{\"name\": \"nasty1\", \"parentID\": 2}, {\"name\": \"noy1\", \"parentID\": 2}]}");
		interop.updateAccount(1L, "{\"title\":\"Ms\",\"artists\": [{\"name\": \"nasty1\", \"parentID\": 2}, {\"name\": \"noy1\", \"parentID\": 2}]}");
		interop.getAllCDs();
	}

}
