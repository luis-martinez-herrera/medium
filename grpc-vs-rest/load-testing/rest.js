import http from 'k6/http';
import { sleep } from 'k6';
export const options = {
  vus: 32,
  duration: '60s',
};
export default function () {
  // http.get('http://localhost:8080/hello');
  http.get('http://184.73.146.165:8080/hello');
  sleep(1);
}