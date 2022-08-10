import http from 'k6/http';
import { sleep } from 'k6';
export const options = {
  vus: 10,
  duration: '2s',
};
export default function () {
  http.get('http://localhost:8080/hello');
  sleep(1);
}