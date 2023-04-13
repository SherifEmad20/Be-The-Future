import { Customer } from "./customer";

export class Product {

    id!: number;
    productName!: string;
    description!: string;
    price!: number;
    photo!: string;
    deadline!: string;
    state!: string;

    customer!: Customer[];
    

}
