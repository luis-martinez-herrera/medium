import grpc from 'k6/net/grpc';
import { check, sleep } from 'k6';
export const options = {
  vus: 10,
  duration: '20s',
};

const client = new grpc.Client();
client.load(['definitions'], '../../src/main/proto/helloworld.proto');

export default () => {
  client.connect('localhost:9000', {
    plaintext: true,
    timeout: 500
  });

  const data = {};
  const response = client.invoke('helloworld.Greeter/SayHello', data);

  check(response, {
    'status is OK': (r) => r && r.status === grpc.StatusOK,
  });

  // console.log(JSON.stringify(response.message));

  client.close();
  sleep(1);
};