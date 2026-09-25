import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Customer  } from './components/customer/customer';


@Component({
  imports: [RouterOutlet, Customer],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('microservices-client');
}
