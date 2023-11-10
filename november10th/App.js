import { Text, View } from "react-native"
import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import home from "./screens/home"
import meal from "./screens/meal"
import about from "./screens/about"


const Stack = createNativeStackNavigator()

export default function App() {
  <NavigationContainer>
    <Stack.Navigator initialRouteName="home">
      <Stack.Screen name="home" component={home} options={{ headerShown: false }}></Stack.Screen>
      <Stack.Screen name="meal" component={meal}></Stack.Screen>
      <Stack.Screen name="about" component={about}></Stack.Screen>
    </Stack.Navigator>
  </NavigationContainer>

}