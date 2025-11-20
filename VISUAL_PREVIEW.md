# Visual Preview - Headlines Landing Screen

This document shows what the Headlines landing screen will look like when the app runs.

## App Launch Screen

```
╔═══════════════════════════════════════════════════════════════════╗
║                                                                   ║
║                      Articles Headlines                           ║
║                                                                   ║
╠═══════════════════════════════════════════════════════════════════╣
║                                                                   ║
║  ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓  ║
║  ┃  ┌──────────┐                                            ┃  ║
║  ┃  │          │  Breaking: New Technology Advances        ┃  ║
║  ┃  │  [IMG]   │  in AI                                  🔖┃  ║
║  ┃  │          │                                            ┃  ║
║  ┃  │  80x80   │  Scientists have made groundbreaking      ┃  ║
║  ┃  │          │  discoveries in artificial...             ┃  ║
║  ┃  │          │                                            ┃  ║
║  ┃  └──────────┘                                            ┃  ║
║  ┃               Tech News • Jane Smith                     ┃  ║
║  ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ║
║                                                                   ║
║  ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓  ║
║  ┃  ┌──────────┐                                            ┃  ║
║  ┃  │          │  Global Climate Summit Reaches            ┃  ║
║  ┃  │  [IMG]   │  Historic Agreement                     🔖┃  ║
║  ┃  │          │                                            ┃  ║
║  ┃  │  80x80   │  World leaders have agreed on new         ┃  ║
║  ┃  │          │  measures to combat...                    ┃  ║
║  ┃  │          │                                            ┃  ║
║  ┃  └──────────┘                                            ┃  ║
║  ┃               World News • John Doe                      ┃  ║
║  ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ║
║                                                                   ║
║  ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓  ║
║  ┃  ┌──────────┐                                            ┃  ║
║  ┃  │          │  Stock Market Reaches All-Time High      ┃  ║
║  ┃  │  [IMG]   │                                          🔖┃  ║
║  ┃  │          │                                            ┃  ║
║  ┃  │  80x80   │  The stock market has hit record highs    ┃  ║
║  ┃  │          │  as investors...                          ┃  ║
║  ┃  │          │                                            ┃  ║
║  ┃  └──────────┘                                            ┃  ║
║  ┃               Business Today • Sarah Johnson             ┃  ║
║  ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ║
║                                                                   ║
║                          ⋮                                        ║
║                   (Scroll for more)                               ║
║                          ⋮                                        ║
║                                                                   ║
╠═══════════════════════════════════════════════════════════════════╣
║                                                                   ║
║     ┏━━━━━━━━━━━┓    ┌───────────┐    ┌───────────┐            ║
║     ┃ 📰         ┃    │ 📋        │    │ 🔖        │            ║
║     ┃ Headlines  ┃    │ Sources   │    │ Saved     │            ║
║     ┗━━━━━━━━━━━┛    └───────────┘    └───────────┘            ║
║                                                                   ║
╚═══════════════════════════════════════════════════════════════════╝

Legend:
━━━ = Selected tab (Headlines)
─── = Unselected tabs
┏┓┗┛ = Material Card with elevation
🔖 = Bookmark/Save button
```

## Color Scheme (Material 3)

### Light Mode
```
┌─────────────────────────────────────────────┐
│ Status Bar:      Primary Color (#6650a4)    │
├─────────────────────────────────────────────┤
│ App Bar:         Surface                    │
│ Background:      Surface (#FFFFFF)          │
│ Cards:           Surface Container          │
│ Text:            On Surface (#1C1B1F)       │
│ Source Names:    Primary (#6650a4) ★        │
│ Author Names:    On Surface Variant         │
│ Icons:           Primary (#6650a4)          │
│ Bottom Nav Bar:  Surface Container          │
│ Selected Tab:    Primary Container          │
└─────────────────────────────────────────────┘
```

### Dark Mode (Android 12+)
```
┌─────────────────────────────────────────────┐
│ Status Bar:      Primary Color              │
├─────────────────────────────────────────────┤
│ App Bar:         Surface                    │
│ Background:      Surface (#1C1B1F)          │
│ Cards:           Surface Container          │
│ Text:            On Surface (#E6E1E5)       │
│ Source Names:    Primary (#D0BCFF) ★        │
│ Author Names:    On Surface Variant         │
│ Icons:           Primary (#D0BCFF)          │
│ Bottom Nav Bar:  Surface Container          │
│ Selected Tab:    Primary Container          │
└─────────────────────────────────────────────┘
```

## Interaction States

### 1. Initial Load
```
╔═══════════════════════════════════════╗
║                                       ║
║           Articles Headlines          ║
║                                       ║
║                  ⟳                    ║
║              Loading...               ║
║                                       ║
║                                       ║
║                                       ║
║   [Headlines]  [Sources]  [Saved]    ║
╚═══════════════════════════════════════╝
```

### 2. Article Card - Default State
```
┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
┃  [Image]  Article Title             🔖┃
┃           Description...              ┃
┃           Source • Author             ┃
┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
```

### 3. Article Card - Pressed State (Ripple)
```
┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
┃  [Image]  Article Title             🔖┃
┃           Description...        ⚡︎    ┃  ← Ripple effect
┃           Source • Author             ┃
┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
```

### 4. Save Button - Pressed
```
┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
┃  [Image]  Article Title            🔖̲ ┃  ← Highlighted
┃           Description...              ┃
┃           Source • Author             ┃
┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛

     Toast: "Article saved" ✓
```

### 5. No Articles State
```
╔═══════════════════════════════════════╗
║                                       ║
║           Articles Headlines          ║
║                                       ║
║                                       ║
║         No articles available         ║
║                                       ║
║                                       ║
║                                       ║
║   [Headlines]  [Sources]  [Saved]    ║
╚═══════════════════════════════════════╝
```

### 6. Error State
```
╔═══════════════════════════════════════╗
║                                       ║
║           Articles Headlines          ║
║                                       ║
║                                       ║
║      ⚠️  Failed to load articles      ║
║         Please try again              ║
║                                       ║
║                                       ║
║   [Headlines]  [Sources]  [Saved]    ║
╚═══════════════════════════════════════╝
```

## Sample Article Content

### Article 1: Technology
```
Title:       Breaking: New Technology Advances in AI
Description: Scientists have made groundbreaking discoveries 
             in artificial intelligence that could...
Author:      Jane Smith
Source:      Tech News
Image:       [Tech/AI themed thumbnail]
```

### Article 2: Climate
```
Title:       Global Climate Summit Reaches Historic Agreement
Description: World leaders have agreed on new measures to 
             combat climate change in a landmark...
Author:      John Doe
Source:      World News
Image:       [Climate/Environment themed thumbnail]
```

### Article 3: Business
```
Title:       Stock Market Reaches All-Time High
Description: The stock market has hit record highs as 
             investors show renewed confidence...
Author:      Sarah Johnson
Source:      Business Today
Image:       [Finance/Business themed thumbnail]
```

### Article 4: Health
```
Title:       New Medical Breakthrough in Cancer Treatment
Description: Researchers announce a potential cure for 
             certain types of cancer after...
Author:      Dr. Emily Brown
Source:      Health Today
Image:       [Medical/Health themed thumbnail]
```

### Article 5: Science
```
Title:       Space Mission Successfully Lands on Mars
Description: A historic space mission has successfully 
             landed on Mars, marking a new era...
Author:      Michael Chen
Source:      Science Daily
Image:       [Space/Science themed thumbnail]
```

## Navigation Flow

```
App Launch
    │
    ▼
Headlines Tab (Active) ─┐
    │                   │
    │                   ├─► Tap Sources Tab → Sources Screen
    │                   │
    │                   └─► Tap Saved Tab → Saved Screen
    │
    ├─► Tap Article → (Future: Article WebView)
    │
    └─► Tap Save → (Future: Save to Database + Toast)
```

## Component Breakdown

### Article Card Anatomy
```
┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
┃                                          ┃
┃  ┌────────┐  ┌──────────────────────┐  🔖┃
┃  │        │  │ Title (titleMedium)  │  │ ┃
┃  │ Image  │  │ Bold, 2 lines max    │  │ ┃
┃  │ 80x80  │  └──────────────────────┘  │ ┃
┃  │ dp     │                            │ ┃
┃  │        │  ┌──────────────────────┐  │ ┃
┃  │ Coil   │  │ Description          │  Save
┃  │ Loaded │  │ (bodyMedium)         │  Button
┃  │        │  │ 2 lines max          │  │ ┃
┃  └────────┘  └──────────────────────┘  │ ┃
┃                                         │ ┃
┃              ┌──────────────────────┐  │ ┃
┃              │ Source • Author      │  │ ┃
┃              │ (labelSmall)         │  │ ┃
┃              └──────────────────────┘  │ ┃
┃                                          ┃
┃  12dp padding all around                 ┃
┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
   8dp corner radius
   2dp elevation
```

## Spacing & Layout

```
Screen Layout:
┌─────────────────────────────┐
│ Status Bar                  │
├─────────────────────────────┤
│                             │  ← Top padding: 0dp
│  ┏━━━━━━━━━━━━━━━━━━━━┓   │
│  ┃ Article Card       ┃   │
│  ┗━━━━━━━━━━━━━━━━━━━━┛   │
│                             │  ← Gap: 8dp
│  ┏━━━━━━━━━━━━━━━━━━━━┓   │
│  ┃ Article Card       ┃   │
│  ┗━━━━━━━━━━━━━━━━━━━━┛   │
│                             │  ← Gap: 8dp
│  ┏━━━━━━━━━━━━━━━━━━━━┓   │
│  ┃ Article Card       ┃   │
│  ┗━━━━━━━━━━━━━━━━━━━━┛   │
│                             │
├─────────────────────────────┤
│ Bottom Navigation (56dp)    │
└─────────────────────────────┘

Horizontal margins: 16dp
Vertical spacing: 8dp between cards
Card padding: 12dp
```

## Typography Scale

```
Title:       titleMedium (16sp, Bold)
Description: bodyMedium (14sp, Regular)
Metadata:    labelSmall (11sp, Medium)

Font: System default (Roboto on most Android devices)
Line height: 1.5x font size
Letter spacing: Standard Material 3
```

## Accessibility

- ✅ Content descriptions on images
- ✅ Semantic labels on buttons
- ✅ Sufficient touch targets (48dp minimum)
- ✅ Contrast ratios meet WCAG AA
- ✅ Screen reader support
- ✅ Scalable text

## Performance

- ✅ LazyColumn for efficient scrolling
- ✅ Image caching with Coil
- ✅ State hoisting for recomposition optimization
- ✅ Stable keys for list items

---

This is how the Headlines landing screen will appear when you run the app! 🎉
