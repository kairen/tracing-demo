import { APP_INITIALIZER, Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DataViewModule } from 'primeng/dataview';
import { ButtonModule } from 'primeng/button';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule, DatePipe } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,RouterOutlet,DataViewModule,ButtonModule,ReactiveFormsModule,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  /**
   * title
   * @memberof AppComponent
   */
  title = 'store-app';

  catalogsAPIUrl:any = '';

  ordersAPIUrl:any = '';

  catalogs:any;

  constructor(private http: HttpClient) {
  }


  ngOnInit(): void {
    this.http.get<any>('/assets/config.json').subscribe(item=>{
      this.catalogsAPIUrl=item.catalogURL;
      this.ordersAPIUrl=item.orderURL;
      this.http.get<any>(this.catalogsAPIUrl).subscribe(item=>{
        this.catalogs=item.data;
      });
    })

  }

  placeOrder(sku:string){
    const body = { sku: sku, amt: 5 };
    this.http.post<any>(this.ordersAPIUrl, body).subscribe(
      response => {
        console.log('Order placed successfully:', response);
        alert('操作成功\n訂單編號:'+response.data+'\n'+'traceId:'+response.traceId);
      },
      error => {
        console.error('Error placing order:', error);
        alert('操作失敗，稍後再試!');
      }
    );
  }

}
