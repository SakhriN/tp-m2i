import { useEffect, useState } from "react"
import { MEALS } from "../data/data"
import { StyleSheet, Text, FlatList, Pressable, Image, View } from "react-native";

export default function MealScreen({ navigation, route }) {
    const id = route.params.id
    const [Jonathan, setJonathan] = useState(MEALS)
    useEffect(() => {
        console.log(id)
        setJonathan(prevJonathan => prevJonathan.filter((item) => item.categoryIds.includes(id)))
        console.log(Jonathan)
    }, [])
    return (

        <>
            <FlatList data={Jonathan} contentContainerStyle={styles.container} renderItem={({ item }) => {
                return (
                    <View>

                        <Pressable style={styles.box} onPress={() => navigation.navigate("AboutScreen", { id: item.id })}>
                            <Image style={styles.image} source={{ uri: item.imageUrl }} />
                            <Text style={styles.test}>{item.title}</Text>
                            <Text style={styles.test}>{item.duration}</Text>
                            <Text style={styles.test}>{item.complexity}</Text>
                        </Pressable>
                    </View>
                )
            }
            } keyExtractor={item => item.id} />
        </>


    )
}

const styles = StyleSheet.create({
    container: {
        alignContent: "center"
    },
    box: {
        marginBottom: 15,
    },
    test: {
        justifyContent: "space-between",
        backgroundColor: "gray",
    },
    text: {
        color: "black",
    },
    image: {
        width: "100%",
        height: 300,
    }
})