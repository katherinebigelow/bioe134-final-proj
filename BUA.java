import java.util.ArrayList;
import java.util.Date;

/**
 *
 * Final version of this file should be translatable to an actual BUA.
 *
 * Created by Katherine on 11/10/2017.
 */
public class BUA {
    private String piName;
    private String piTitle;
    private Date date;
    private int phone;
    private String dept;
    private String address;
    private String email;
    private int fax;
    private int mailCode;
    private String[]funding_sources;
    private int[]grant_nos;
    private Date startDate;
    private Date endDate;
    private String objective;
    private ArrayList<Integer>checkboxes;
    private boolean[]needAttachment;
    private boolean[]attached;

    public void setPiName(String piName) {
        this.piName = piName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCheckboxes(ArrayList<Integer> checkboxes) {
        this.checkboxes = checkboxes;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMailCode(int mailCode) {
        this.mailCode = mailCode;
    }

    public void setFunding_sources(String[] funding_sources) {
        this.funding_sources = funding_sources;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPiTitle(String piTitle) {
        this.piTitle = piTitle;
    }

    public void setAttached(boolean[] attached) {
        this.attached = attached;
    }

    public void setGrant_nos(int[] grant_nos) {
        this.grant_nos = grant_nos;
    }

    public void setNeedAttachment(boolean[] needAttachment) {
        this.needAttachment = needAttachment;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean allAttached(){
        for(int i = 0; i<needAttachment.length; i++){
            if(needAttachment[i]&&!attached[i]){
                return false;
            }
        }
        return true;
    }

    //personnel
    //location (boxes)
    //bio materials storage (boxes)

    //safety eval: more boxes

}
