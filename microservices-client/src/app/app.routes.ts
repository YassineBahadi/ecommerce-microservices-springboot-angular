import { Routes } from '@angular/router';
import {Customer} from './components/customer/customer';
import { Product } from './components/product/product';
import { Invoice } from './components/invoice/invoice';
export const routes: Routes = [
      {
    path: '',
    redirectTo: 'customers',
    pathMatch: 'full'
  },
     {
    path: 'customers',
    component: Customer,
  },
   {
    path: 'products',
    component: Product,
  },
   {
    path: 'invoices',
    component: Invoice,
  }
];
