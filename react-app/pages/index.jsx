import { Box, Button, Flex, Image, Input, Text } from "@chakra-ui/react";
import Head from "next/head";

import { useState } from "react";
import styles from "../styles/Home.module.css";
import { signInWithGoogle } from "../utils/firebase";

export default function Home() {
  const [user, setUser] = useState(null);

  async function signIn() {
    const u = await signInWithGoogle();
    if (u) {
      setUser(u);
      console.log(u);
    }
  }

  if (user == null) {
    return (
      <Flex bg="#3a2deb" w="100vw" h="100vh">
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
        >
          <Text fontWeight={"bold"}>Bem Vindo</Text>
          <Button onClick={signIn}>Login With Google</Button>
        </Flex>
      </Flex>
    );
  }
  return (
    <Box bg="#f7f9f9">
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
          <Image
            src={user && user.photoURL}
            w="50px"
            height={"50px"}
            borderRadius="50px"
          />
          <Input
            placeholder="Whats's happening"
            border={"none"}
            outline="none"
            _focus={{
              outline: "none",
            }}
            maxLength="140"
          ></Input>
        </Flex>
        <Flex
          w="100%"
          justifyContent={"flex-end"}
          borderBottom="1px solid #8f8f8f6a"
          padding={"5px 0"}
        >
          <Button bg="#671df0" color="#FFF" borderRadius={"40px"}>
            Tweet
          </Button>
        </Flex>
        {[1, 2, 3, 4].map((item, i) => {
          return <Twitt key={i} />;
        })}
        {/* <Button onClick={signIn}>Login</Button> */}
      </Flex>
    </Box>
  );
}

const Twitt = () => {
  return (
    <Flex borderBottom="1px solid #8f8f8f6a" marginY="15px">
      <Image
        // src={user && user.photoURL}
        minH={"50px"}
        minW={"50px"}
        w="50px"
        height={"50px"}
        borderRadius="50px"
      />
      <Flex flexDir={"column"} padding={"0 10px 15px 15px"}>
        <Text fontSize={"15px"} fontWeight="bold">
          Fulano
        </Text>
        <Text fontSize={"15px"}>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae ab
          aliquid obcaecati optio, corrupti id. Ipsum, ipsa quae vel
          voluptatibus vitae ab cumque! Quos iure harum reiciendis odio dolorem?
          Quibusdam!
        </Text>
      </Flex>
    </Flex>
  );
};
