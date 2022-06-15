import javafx.application.Application;
import javafx.stage.Stage;
import lk.SuperMarket.entity.Customer;
import lk.SuperMarket.entity.Item;
import lk.SuperMarket.entity.OrderDetails;
import lk.SuperMarket.entity.Orders;
import lk.SuperMarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer{

    public static void main(String[] args) {

        //CUSTOMER
        Customer c1 = new Customer("C001", "Hasindi", "Galle", 100000);
        Customer c2 = new Customer("C002", "Malki", "Galle", 45000);
        Customer c3 = new Customer("C003", "Supun", "Imaduwa", 30000);
        Customer c4 = new Customer("C004", "Dasun", "Mathara", 90000);

        //ITEM
        Item i1 = new Item("I001", "MilkPowder", 745, 50);
        Item i2 = new Item("I002", "LUX Soap", 195, 100);
        Item i3 = new Item("I003", "Sugar", 340, 100);
        Item i4 = new Item("I004", "chocolate", 540, 300);

        //ORDER
        Orders o1 = new Orders("O001",c1);
        Orders o2 = new Orders("O002",c2);
        Orders o3 = new Orders("O003",c2);

        //ORDERDETAILS
        OrderDetails od1 = new OrderDetails("OD001", o1, i1, 2, i1.getUnitPrice());
        OrderDetails od2 = new OrderDetails("OD002", o1, i2, 10, i2.getUnitPrice());
        OrderDetails od3 = new OrderDetails("OD003", o1, i3, 3, i3.getUnitPrice());
        OrderDetails od4 = new OrderDetails("OD004", o2, i3, 2, i3.getUnitPrice());
        OrderDetails od5 = new OrderDetails("OD005", o3, i4, 100, i4.getUnitPrice());


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();



        /*CUSTOMER*/
        //save
        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(c4);

        //read
        Customer cus1 = session.get(Customer.class, "C004");
        System.out.println(cus1.getId()+" - " + cus1.getName() + " - " + cus1.getAddress() + " - " + cus1.getSalary());

        //update
        c2.setAddress("Karapitiya");
        session.update(c2);

        //delete
        session.delete(session.get(Customer.class,"C003"));



        /*ITEM*/

        //save
        session.save(i1);
        session.save(i2);
        session.save(i3);
        session.save(i4);

        //read
        Item item = session.get(Item.class, "I004");
        System.out.println(item);

        //update
        i3.setQtyOnHand(80);
        session.update(i3);

        //delete
        session.delete(session.get(Item.class,"I004"));



        /*ORDER*/

        //save
        session.save(o1);
        session.save(o2);
        session.save(o3);

        //read
        Orders order = session.get(Orders.class, "O003");
        System.out.println(order.getId()+" - "+order.getDate());

        //update
        o3.setCustomer(c4);
        session.update(o3);

        //delete
        session.delete(order);



        /*ORDERDETAILS*/

        //save
        session.save(od1);
        session.save(od2);
        session.save(od3);
        session.save(od4);
        session.save(od5);

        //read
        OrderDetails orderDetails = session.get(OrderDetails.class, "OD005");
        System.out.println(orderDetails.getId()+" - " + orderDetails.getUnitPrice() + " - "+orderDetails.getQty());

        //update
        od2.setQty(20);
        session.update(od2);

        //delete
        session.delete(od5);


        transaction.commit();
        session.close();
    }
}
