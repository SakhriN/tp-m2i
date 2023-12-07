
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import Home from "./screens/Home"
import MealScreen from "./screens/MealScreen"
import AboutScreen from "./screens/AboutScreen"


const Stack = createNativeStackNavigator()

export default function App() {

  return (
  <NavigationContainer>
    <Stack.Navigator initialRouteName="Home">
      <Stack.Screen name="Home" component={Home} options={{ title:"All Categories", headerShown: false }} />
      <Stack.Screen name="MealScreen" component={MealScreen} options={{ title:"MealsOverview"}}/>
      <Stack.Screen name="AboutScreen" component={AboutScreen} options={{ title:"About the Meal"}}/>
    </Stack.Navigator>
  </NavigationContainer>
  )
}