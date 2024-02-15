class Customer {
    public static String customerName;
    public static String customerType;

    Customer ( String name ) {
        customerName = name;
    }

    public void setCustomerName ( String name ) {
        customerName = name;
    }

    public void setCustomerType ( String type ) {
        customerType = type;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerType () {
        return customerType;
    }
}

class Sale {
    Customer customer;
    String date;
    double serviceExpense;
    double productExpense;

    Sale ( Customer obj, String date ) {
        customer = obj;
        this.date = date;
    }

    public void setServiceExpense ( double serviceExpense ) {
        this.serviceExpense = serviceExpense;
    }

    public void setProductExpense ( double setProductExpense ) {
        this.productExpense = setProductExpense;
    }

    public String getDate () {
        return date;
    }

    public double getServiceExpense () {
        int discount = 0;

        if ( customer.getCustomerType().equals( "Premium" )) discount = 20;
        else if ( customer.getCustomerType().equals( "Gold" )) discount = 15;
        else if ( customer.getCustomerType().equals( "Silver" )) discount = 10;
        else if ( customer.getCustomerType().equals( "Normal" )) discount = 0;

        return ( serviceExpense / 100 ) * discount;
    }

    public double getProductExpense () {
        int discount = 0;

        if ( customer.getCustomerType().equals( "Premium" )
                || customer.getCustomerType().equals( "Gold" )
                    || customer.getCustomerType().equals( "Silver" )) discount = 10;
        else if ( customer.getCustomerType().equals( "Normal" )) discount = 0;

        return ( serviceExpense / 100 ) * discount;
    }

    public double getTotalExpense () {
        return getProductExpense() + getServiceExpense();
    }

    public void displayInfo() {
        System.out.println( "Customer info:" );
        System.out.println( "Customer name   : " + customer.getCustomerName());
        System.out.println( "Customer type   : " + customer.getCustomerType());
        System.out.println( "Service expense : " + getServiceExpense());
        System.out.println( "Product expense : " + getProductExpense());
    }
}

public class index {
    public static void main( String args[] ) {
        Customer c1 = new Customer("Sovisal");
        Customer c2 = new Customer("Sokchea");
        Customer c3 = new Customer("Sokpov");
        Customer c4 = new Customer("Vitou");

        c2.setCustomerType("Premium");
        c3.setCustomerType("Gold");
        c4.setCustomerType("Silver");

        Sale sale_c1 = new Sale(c1,"2024-02-11");
        Sale sale_c2 = new Sale(c2,"2024-02-12");
        Sale sale_c3 = new Sale(c3,"2024-02-13");
        Sale sale_c4 = new Sale(c4,"2024-02-14");

        sale_c1.setProductExpense(100);
        sale_c1.setServiceExpense(100);
        sale_c1.displayInfo();

        sale_c2.setProductExpense(100);
        sale_c2.setServiceExpense(100);
        sale_c2.displayInfo();

        sale_c3.setProductExpense(100);
        sale_c3.setServiceExpense(100);
        sale_c3.displayInfo();

        sale_c4.setProductExpense(100);
        sale_c4.setServiceExpense(100);
        sale_c4.displayInfo();
    }
}