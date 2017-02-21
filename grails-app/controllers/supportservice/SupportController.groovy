package supportservice

import grails.rest.RestfulController
import org.aspectj.apache.bcel.Repository
import org.eclipse.egit.github.core.Issue
import org.eclipse.egit.github.core.client.GitHubClient
import org.eclipse.egit.github.core.service.IssueService
import org.eclipse.egit.github.core.service.IssueService
import org.eclipse.egit.github.core.service.RepositoryService
import org.eclipse.egit.github.core.service.RepositoryService


class SupportController extends RestfulController{

    
    static responseFormats = ['json']
  //  def index() { }
    
    def supportmail(String sub, String msg, String email)
    {       

       // String message="<p>Dear User</p><p>Thanks for your valuable feedback.</p><p>we have received your feedback message and will revert back to you soon.</p><p>Your message is:</p><p>"+msg+"</p>"
        String message= msg
        try
        {
            ////////////////////Sending Mail////////////
            sendMail 
            {     
                to " support@healthelife.in"     
                subject sub
                body msg
            }
             sendMail 
            {     
                to email     
                subject "Thank you for your feedback"
               // body msgBody
                html view: "/support/email", model: [message: message]
            }

           
            
            render(contentType: "application/json"){["Response" : "Success"]}  //sending json response as success
        
            
//            def User,Password,Repository,AssignedUser
//            //GitHub Credentials//////	 
//            User="AbhinayThakur"
//            Password="1234abcd"
//            Repository="WorkSpace"
//            AssignedUser = "Abhinay2" // user to assign issue
//
//            org.eclipse.egit.github.core.User user2 = new org.eclipse.egit.github.core.User();
//            user2.setLogin(AssignedUser);
//		 
//            GitHubClient client = null
//            try {
//		client = new GitHubClient();
//		client.setCredentials(User, Password);
//            } catch (Exception e1) {
//		
//		e1.printStackTrace();
//            }
//		 
//            IssueService issueService= new IssueService(client);
//            Issue issue=new Issue();
//            issue.setTitle(sub);
//            issue.setBody(msg);
//            issue.setAssignee(user2);
//
//
//            try {
//		issueService.createIssue(User, Repository, issue);
//            } catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//            }

           
            
        }catch(Exception e)
        {
           print e
            render(contentType: "application/json"){["Response" : "Fail"]}
               
             
        }
    }
}
