import { Product } from "./product.model";

export class FeedbackModel{
    public feedbackId:number;
    public name:string;
    public stars:number;
    public comments:string;
    public prod:Product;
    public prodId:number;

}