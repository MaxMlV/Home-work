package objectLecture.blackList;

import java.util.Arrays;

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

    public int checkForBlackness(Object objToCheck, BlackList blackList) {
        Object[] blackObjects = blackList.getObjects();
        for (int i = 0; i < blackObjects.length; i++) {
            if (blackObjects[i] != null && blackObjects[i].equals(objToCheck)) {
                return 1;
            }
        }
        return 0;
    }

    public void addObject(Object objToAdd, BlackList blackList) {
        if (checkForBlackness(objToAdd, blackList) == 0) {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    objects[i] = objToAdd;
                    break;
                }
            }
        }
    }

    public void deleteObject() {
        for (int i = objects.length-1; i >= 0; i--) {
            if (objects[i] != null) {
                objects[i] = null;
                break;
            }
        }
    }

    public Object topOfStack() {
        for (int i = objects.length-1; i >= 0; i--) {
            if (objects[i] != null) {
                return objects[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}
