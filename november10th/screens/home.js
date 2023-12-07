import { StyleSheet, Text, FlatList, Pressable, ScrollView } from "react-native";
import { CATEGORIES, MEALS } from "../data/data";
import { useState } from "react";
export default function Home({ navigation }) {
    const [Dio, setDio] = useState(CATEGORIES)




    return (
        <ScrollView>
            <FlatList data={Dio} numColumns={2} contentContainerStyle={styles.container} renderItem={({ item }) => {
                return (
                    <Pressable onPress={() => navigation.navigate("MealScreen", { id: item.id })} style={[styles.test, { backgroundColor: item.color }]}><Text style={styles.text}>{item.title}</Text></Pressable>
                )
            }
            } keyExtractor={item => item.id} />
        </ScrollView>

    )



}

const styles = StyleSheet.create({
    container: {
    },

    test: {
        margin: 20,
        width: 170,
        height: 170,

    },
    text: {
        textAlign: "center",
        lineHeight: 170,
        color: "black",
    }
})


