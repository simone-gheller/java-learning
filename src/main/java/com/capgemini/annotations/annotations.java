package com.capgemini.annotations;

@MyAnnotation(getNumber = 10)
@DefaultAnn(true)
public class annotations {

    public static void main(String[] args) {
        MyAnnotation myAnnotation = annotations.class.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.getNumber());
        DefaultAnn defaultAnn = annotations.class.getAnnotation(DefaultAnn.class);
        System.out.println(defaultAnn.value());
    }

}
