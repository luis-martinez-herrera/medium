import grpc from 'k6/net/grpc';
import { check, sleep } from 'k6';
export const options = {
  vus: 1,
  duration: '1s',
};

const client = new grpc.Client();
client.load(['definitions'], '../../src/main/proto/helloworld.proto');

export default () => {
  client.connect('184.73.146.165:9000', {
    plaintext: true,
    timeout: 500
  });

  const data = {
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
  const response = client.invoke('helloworld.Greeter/SayHello', data);

  // check(response, {
  //   'status is OK': (r) => r && r.status === grpc.StatusOK,
  // });

  console.log(JSON.stringify(response.message));

  // client.close();
  sleep(1);
};