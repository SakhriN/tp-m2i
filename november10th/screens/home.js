import { StyleSheet, Text, FlatList, Pressable } from "react-native";
import { CATEGORIES, MEALS } from "../data/data";
import { useState } from "react";
export default function Home({ navigation }) {
    const [Dio, setDio] = useState(CATEGORIES)




    return (
        <>
            <FlatList data={Dio} numColumns={2} contentContainerStyle={styles.container} renderItem={({ item }) => {
                return (
                    <Pressable onPress={()=>navigation.navigate("MealScreen", {id:item.id})} style={styles.test}><Text style={{backgroundColor:item.color}}>{item.title}</Text></Pressable>
                )
            }
            } keyExtractor={item => item.id} />
        </>

    )



}

const styles = StyleSheet.create({
    container: {
        alignContent: "center",
    },

    test: {
        justifyContent: "space-between",
        margin:20,
    },
    text: {
        color: "black",
    }
})


