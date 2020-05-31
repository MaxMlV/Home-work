package objectLecture.groupData;

import java.io.Serializable;

public class Faculty implements Serializable {
    private Group[] groups = new Group[5];

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public void addToGroup(int groupNumber, Student student) {
        getGroups()[groupNumber].addStudent(student);
    }
}
