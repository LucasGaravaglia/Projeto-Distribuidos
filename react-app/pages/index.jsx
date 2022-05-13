import { Box, Button, Flex, Image, Input, Text } from "@chakra-ui/react";
import { BiLogOut } from "react-icons/bi";
import { useState, useContext } from "react";
import AuthContext from "../contexts/AuthContext";
import MqttContext from "../contexts/MqttContext";
import { BsFillChatDotsFill } from "react-icons/bs";
import { RiSendPlane2Fill } from "react-icons/ri";
import { MdCancel } from "react-icons/md";

export default function Home() {
  const [showSendMsg, setShowSendMsg] = useState(false);
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
      <Flex
        w="100vw"
        h="100vh"
        position={"fixed"}
        zIndex="overlay"
        top="0"
        left="0"
        bg="#000000a0"
        // opacity={"0.5"}
        alignItems="center"
        justifyContent={"center"}
        display={showSendMsg ? "flex" : "none"}
      >
        <Flex
          flexDirection={"column"}
          justifyContent="space-between"
          w={{ base: "100vw", md: "50vw" }}
          bg="#ffffff"
          padding={"15px"}
        >
          <Flex padding={"5px"} marginBottom="15px" alignItems="center">
            <Box
              bg={"tomato"}
              minH={"50px"}
              minW={"50px"}
              w="50px"
              height={"50px"}
              borderRadius="50px"
              marginRight={"15px"}
            />

            <Text fontSize={"15px"} fontWeight="bold">
              Fulne
            </Text>
          </Flex>
          <Flex w="100%" alignItems={"center"}>
            <Input
              // border={"1px solid #671DF0"}
              // _focus={{ outline: "#671DF0" }}
              colorScheme={"pink"}
              boxShadow="rgba(149, 157, 165, 0.2) 0px 8px 24px;"
              w={"100%"}
            />
            <Flex cursor={"pointer"}>
              <Box
                onClick={() => setShowSendMsg(false)}
                _hover={{ opacity: 0.5 }}
                marginX={"10px"}
              >
                <MdCancel size={30} color="#c3c3c3" />
              </Box>
              <Box _hover={{ opacity: 0.5 }}>
                <RiSendPlane2Fill size={30} color="#671DF0" />
              </Box>
            </Flex>
          </Flex>
        </Flex>
      </Flex>
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
                onClickMsg={() => setShowSendMsg(true)}
              />
            );
          })}
      </Flex>
    </Box>
  );
}

const Tweet = ({ userName, msg, color, timestamp, onClickMsg }) => {
  return (
    <Flex
      borderBottom="1px solid #8f8f8f6a"
      marginY="15px"
      justifyContent={"space-between"}
      alignItems="center"
      w="100%"
    >
      <Flex>
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
      <Box
        onClick={onClickMsg}
        cursor={"pointer"}
        color="#c3c3c3"
        _hover={{ color: "#671DF0" }}
      >
        <BsFillChatDotsFill size={25} />
      </Box>
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
