import { ProductModel } from "./productAL.model";

export class Cartlist{
    public cartId : number;
	public pro_id : ProductModel;
    public cust_id : number;
    public quantity : number;
    public tprice:number;
    public finalprice : number;
}