import http from 'k6/http';
import { sleep } from 'k6';
export const options = {
  vus: 1,
  duration: '1s',
};
export default function () {
  // http.get('http://localhost:8080/hello');
  // http.get('http://184.73.146.165:8080/hello');
  let requestData = {
    name : "1",
    name1 : "2",
    name2 : "3",
    name3 : "4",
    name4 : "5",
    name5 : "6",
    name6 : "7",
    name7 : "8",
    name8 : "9",
    name9 : "1",
    name0 : "1",
    name11 : "1",
    name22 : "1",
    name33 : "1",
    name44 : "1",
    name55 : "1",
    name66 : "1",
    name77 : "1",
    name88 : "1",
    name99 : "1",
    name00 : "1",
    name111 : "2",
    name222 : "2",
    name333 : "2",
    name444 : "2",
  };

  http.request('GET', 'http://184.73.146.165:8080/hello', JSON.stringify(requestData), {
    headers: { 'Content-Type': 'application/json' },
  });
  sleep(1);
}