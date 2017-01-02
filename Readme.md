## Curl to put pet tracker

* curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: 243818ac-6b7d-7ba4-2fb5-3f4a553a0041" -d '{
    "petId": "ba7da66c-7bc4-4e4e-856d-c47c44d5968e",
    "majorId" : "2999",
    "minorId":"100",
    "reportedUserId":"hrishispi2",
    "coordinates":{
    	"latitude":"37.422366",
    	"longitude":"-122.084406"
    }
}' "http://pet-tracker-elb-1088404280.us-east-1.elb.amazonaws.com/setPetTrackingDetails"

## Http to put pet tracker - 

* POST /setPetTrackingDetails HTTP/1.1
Host: pet-tracker-elb-1088404280.us-east-1.elb.amazonaws.com
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 3b92e2e8-e66f-197c-e0ae-6c3267144a98

{
    "petId": "ba7da66c-7bc4-4e4e-856d-c47c44d5968e",
    "majorId" : "2999",
    "minorId":"100",
    "reportedUserId":"hrishispi2",
    "coordinates":{
    	"latitude":"37.422366",
    	"longitude":"-122.084406"
    }
}

## Curl to get pet tracker

*   curl -X GET -H "Cache-Control: no-cache" -H "Postman-Token: fec15f15-f513-c852-678b-2ad469cc5405" "http://pet-tracker-elb-1088404280.us-east-1.elb.amazonaws.com/getPetTrackingDetails/ba7da66c-7bc4-4e4e-856d-c47c44d5968e"

## Http to get pet tracker 

*   GET /getPetTrackingDetails/ba7da66c-7bc4-4e4e-856d-c47c44d5968e HTTP/1.1
Host: pet-tracker-elb-1088404280.us-east-1.elb.amazonaws.com
Cache-Control: no-cache
Postman-Token: 0e0e81af-17cd-e0cf-77e0-e762741057eb


scp -i RoamingTailsKey.pem /Users/uys445/Documents/workspace/RDS/MyDynamoDemo/target/MyDynamo-0.0.1-SNAPSHOT.jar ec2-user@ec2-54-90-95-123.compute-1.amazonaws.com:/home/ec2-user

screen -r 8309.pts-0.ip-172-31-54-255

java -jar MyDynamo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
