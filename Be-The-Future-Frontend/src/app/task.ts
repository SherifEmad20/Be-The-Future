import { Employee } from "./employee";
import { Product } from "./product";

export class Task {

    id!: number;
    taskName!: string;
    taskDescription!: string;
    taskStartDate!: string;
    taskDeadline!: string;

    product!: Product[];
    employee!: Employee[];

    done!: boolean;

}
