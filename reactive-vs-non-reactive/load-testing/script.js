import http from 'k6/http';
import { sleep } from 'k6';
export const options = {
    vus: 50,
    duration: '30s',
};
export default function () {
    http.get('http://192.168.0.112:8080/reservations');
    // sleep(1);
}