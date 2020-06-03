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
            if (blackObjects[i].getClass().equals(classToCheck) && blackObjects[i] != null) {
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
                return classToAdd.toString() + "has been added!";
            }
        }
    }

    public void deleteObject(Class<?> classToDelete) {
        int i = 0;
        for (i = objects.length-i-1; i < objects.length; i++) {
            if (objects[i].getClass().equals(classToDelete) && objects[i+1] == null) {
                System.out.println(classToDelete.toString() + "has been deleted!");
                objects[i] = null;
                break;
            } else {
                System.out.println("Object is not on top of stack or doesn't exist.");
            }
        }
    }

    public String topOfStack() {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && objects[i+1] == null || i == objects.length-1) {
                return objects[i].toString() + "<- this object sit on top!";
            }
        }
        return "Stack is empty.";
    }
}
