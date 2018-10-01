package com.hngd.data.bean;

import java.util.Date;

public class Bill {
    private int serial_number;
    private String good_name;
    private String supplier;
    private String bill_amount;
    private String contact_person;
    private String payment_status;
    private String create_time;
    private String good_unit;
    private int good_num;

    public String getGood_unit() {
        return good_unit;
    }

    public void setGood_unit(String good_unit) {
        this.good_unit = good_unit;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "serial_number=" + serial_number +
                ", good_name='" + good_name + '\'' +
                ", supplier='" + supplier + '\'' +
                ", bill_amount='" + bill_amount + '\'' +
                ", contact_person='" + contact_person + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", create_time=" + create_time +
                '}';
    }


    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(String bill_amount) {
        this.bill_amount = bill_amount;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
