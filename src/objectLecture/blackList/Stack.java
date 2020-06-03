package objectLecture.blackList;

public class Stack {
    private Object[] objects;

    public Stack(Object[] objects) {
        this.objects = objects;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public int checkForBlackness(Class<?> classToCheck, BlackList blackList) {
        Object[] blackObjects = blackList.getObjects();
        for (int i = 0; i < blackObjects.length; i++) {
            if (blackObjects[i] != null && blackObjects[i].getClass().equals(classToCheck)) {
                return 1;
            }
        }
        return 0;
    }

    public String addObject(Class<?> classToAdd, BlackList blackList) {
        if (checkForBlackness(classToAdd, blackList) > 0) {
            return classToAdd.toString() + " is in the Black List!!!";
        }
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = classToAdd;
                return classToAdd.toString() + " has been added!";
            }
        }
        return "null";
    }

    public String deleteObject() {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i+1] == null) {
                Object temp = objects[i];
                objects[i] = null;
                return temp.getClass() + " <-- has been deleted.";
            } else if (i == objects.length-1 && objects[i] != null) {
                Object temp = objects[i];
                objects[i] = null;
                return temp.hashCode() + " <-- has been deleted.";
            }
        }
        return "Nothing to delete";
    }

    public String topOfStack() {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && objects[i + 1] == null || i == objects.length - 1) {
                return objects[i].toString() + " <- this object sit on top!";
            }
        }
        return "Stack is empty.";
    }
}
