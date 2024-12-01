import { EPermission } from "./e-permission";

export interface RoleRequest {
    name: String;
    permissions: EPermission[];
}
