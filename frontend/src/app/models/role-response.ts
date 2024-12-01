import { EPermission } from "./e-permission";

export interface RoleResponse {  
    id: String;
    name: String;
    permissions: EPermission[];
   
}
