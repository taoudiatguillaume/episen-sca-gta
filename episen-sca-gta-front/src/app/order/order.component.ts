import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders: Order[];
  order:Order;
  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    //this.orderService.getOrders().subscribe((data: Order[]) => {
      //console.log(data);
      //this.orders = data;
      this.order = new Order();
    //});
  }

  public add_order(): void {
      this.orderService.add_order(this.order).subscribe((data) => {
        this.order = data;
        alert('Add Order With Success');
      });
  }
}
