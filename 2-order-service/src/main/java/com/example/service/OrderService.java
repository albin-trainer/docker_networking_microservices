package com.example.service;

import com.example.model.OrderDetails;

public interface OrderService {
OrderDetails order(int pid,int quantity);
}
