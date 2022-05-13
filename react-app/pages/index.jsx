import { Box, Button, Flex, Image, Input, Text } from "@chakra-ui/react";
import { BiLogOut } from "react-icons/bi";
import { useState, useContext } from "react";
import AuthContext from "../contexts/AuthContext";
import MqttContext from "../contexts/MqttContext";

export default function Home() {
  const [name, setName] = useState("");
  const { user, signIn, isLoading, signOut, isAuthenticated } =
    useContext(AuthContext);

  const { connectStatus, connectMqtt, publishInFeed, tweetsList } =
    useContext(MqttContext);
  const [tweet, setTweet] = useState("");

  function publishTweet() {
    if (tweet.length > 1) {
      console.log(tweet);
      publishInFeed(tweet);
      setTweet("");
    }
  }

  if (!isAuthenticated) {
    return (
      <Flex bg="#196ddc" w="100vw" h="100vh">
        <Flex
          margin="auto"
          width={"300px"}
          height="200px"
          bg="#FFF"
          boxShadow="rgba(196, 196, 196, 0.2) 0px 8px 24px;"
          borderRadius={"10px"}
          alignItems="center"
          justifyContent={"center"}
          flexDirection="column"
          border="1px solid #c1c1c1"
        >
          <Text marginBottom={"15px"} fontWeight={"bold"}>
            Bem Vindo
          </Text>

          <Input
            w={"80%"}
            margin="0px 0 20px 0"
            placeholder="Seu nome aqui"
            type={"text"}
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <Button
            isLoading={isLoading}
            colorScheme={"blue"}
            onClick={() => {
              if (name.length >= 3 && name !== "null" && name !== "undefined") {
                signIn(name);
              }
            }}
          >
            Fazer Login
          </Button>
        </Flex>
      </Flex>
    );
  }
  return (
    <Box bg="#f7f9f9">
      <Box
        width={"30px"}
        height={"30px"}
        position={"fixed"}
        top="15px"
        right="15px"
        cursor={"pointer"}
        _hover={{
          opacity: 0.5,
        }}
        onClick={signOut}
        zIndex={100}
      >
        <BiLogOut size={30} color="#c3c3c3" />
      </Box>
      <Flex
        width={{ base: "100vw", md: "600px" }}
        bg="#FFF"
        minHeight={"100vh"}
        marginX="auto"
        boxShadow="rgba(149, 157, 165, 0.2) 0px 8px 24px;"
        flexDirection={"column"}
        padding={"3%"}
      >
        <Flex>
          <Box
            minH={"50px"}
            minW={"50px"}
            w="50px"
            height={"50px"}
            borderRadius="50px"
            bg={user.color}
          />
          <Input
            placeholder="Whats's happening"
            border={"none"}
            outline="none"
            _focus={{
              outline: "none",
            }}
            onChange={(e) => setTweet(e.target.value)}
            maxLength="140"
            value={tweet}
          ></Input>
        </Flex>
        <Flex
          w="100%"
          justifyContent={"flex-end"}
          borderBottom="1px solid #8f8f8f6a"
          padding={"5px 0"}
        >
          <Button
            onClick={publishTweet}
            bg="#671df0"
            color="#FFF"
            borderRadius={"40px"}
          >
            Tweet
          </Button>
        </Flex>
        {tweetsList.length > 0 &&
          tweetsList.map((t, i) => {
            return (
              <Tweet
                key={i}
                userName={t.name}
                msg={t.msg}
                color={t.color}
                timestamp={t.timestamp}
              />
            );
          })}
      </Flex>
    </Box>
  );
}

const Tweet = ({ userName, msg, color, timestamp }) => {
  return (
    <Flex borderBottom="1px solid #8f8f8f6a" marginY="15px">
      <Box
        bg={color}
        minH={"50px"}
        minW={"50px"}
        w="50px"
        height={"50px"}
        borderRadius="50px"
      />
      <Flex flexDir={"column"} padding={"0 10px 15px 15px"}>
        <Text fontSize={"15px"} fontWeight="bold">
          {userName} - <strong>{getElapsedTime(timestamp)}</strong>
        </Text>
        <Text fontSize={"15px"}>{msg}</Text>
      </Flex>
    </Flex>
  );
};

function getElapsedTime(timestamp) {
  const totalSeconds = (Date.now() - parseInt(timestamp)) / 1000;

  const hours = Math.floor(totalSeconds / 3600);
  const minutes = Math.floor((totalSeconds % 3600) / 60);
  const seconds = Math.floor((totalSeconds % 3600) % 60);

  if (hours !== 0) {
    return `${hours}h`;
  } else if (minutes !== 0) {
    return `${minutes}min`;
  } else return `${seconds}seg`;
}
