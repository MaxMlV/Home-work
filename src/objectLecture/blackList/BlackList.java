package objectLecture.blackList;

public class BlackList {
    private Object[] objects;

    public BlackList(Object[] objects) {
        this.objects = objects;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public void add(Object objToBlackList) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = objToBlackList;
                break;
            }
        }
    }

    public  void delete(Object objToDeleteFromBlackList) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(objToDeleteFromBlackList) && objects[i] != null) {
                objects[i] = null;
            }
        }
    }
}
