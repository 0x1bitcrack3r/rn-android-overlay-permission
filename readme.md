usage
import OverlayPermission from 'rn-android-overlay-permission';

if(Platform.OS==='android'){
OverlayPermission.isRequestOverlayPermissionGranted((status: any) => {
if (status) {
<TouchableOpacity onPress=(()=>{OverlayPermission.requestOverlayPermission()})/>
}
});
}
