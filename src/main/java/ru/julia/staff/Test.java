package ru.julia.staff;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        URL resource = Test.class.getClassLoader().getResource("person.xml");
        Person person = (Person) unmarshaller.unmarshal(resource);
        System.out.println(person);
    }
}
