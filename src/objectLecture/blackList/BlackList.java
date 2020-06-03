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

    public void add(Class<?> classToBlackList) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = classToBlackList;
                break;
            }
        }
    }

    public  void delete(Class<?> classToDeleteFromBlackList) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].getClass().equals(classToDeleteFromBlackList) && objects[i] != null) {
                objects[i] = null;
            }
        }
    }
}
