package lk.SuperMarket.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
    @Id
    private String id;
    @ManyToOne
    private Orders order;
    @ManyToOne
    private Item item;

    private int qty;
    private double unitPrice;

    public OrderDetails(String id, Orders order, Item item, int qty, double unitPrice) {
        this.setId(id);
        this.setOrder(order);
        this.setItem(item);
        this.setQty(qty);
        this.setUnitPrice(unitPrice);
    }

    public OrderDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id='" + id + '\'' +
                ", order=" + order +
                ", item=" + item +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
