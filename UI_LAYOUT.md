# Headlines Landing Screen - UI Layout

This document describes the visual layout of the Headlines landing screen.

## Screen Layout

```
╔═══════════════════════════════════════════════════════════╗
║                  Articles Headlines                       ║
╠═══════════════════════════════════════════════════════════╣
║                                                           ║
║  ┌───────────────────────────────────────────────────┐   ║
║  │  ┌────────┐  Breaking: New Technology Advances   │   ║
║  │  │ [IMG]  │  in AI                               🔖  │
║  │  │        │                                        │   ║
║  │  │ 80x80  │  Scientists have made groundbreaking  │   ║
║  │  │        │  discoveries in artificial...         │   ║
║  │  └────────┘                                        │   ║
║  │              Tech News • Jane Smith               │   ║
║  └───────────────────────────────────────────────────┘   ║
║                                                           ║
║  ┌───────────────────────────────────────────────────┐   ║
║  │  ┌────────┐  Global Climate Summit Reaches       │   ║
║  │  │ [IMG]  │  Historic Agreement                  🔖  │
║  │  │        │                                        │   ║
║  │  │ 80x80  │  World leaders have agreed on new     │   ║
║  │  │        │  measures to combat...                │   ║
║  │  └────────┘                                        │   ║
║  │              World News • John Doe                │   ║
║  └───────────────────────────────────────────────────┘   ║
║                                                           ║
║  ┌───────────────────────────────────────────────────┐   ║
║  │  ┌────────┐  Stock Market Reaches All-Time      │   ║
║  │  │ [IMG]  │  High                                 🔖  │
║  │  │        │                                        │   ║
║  │  │ 80x80  │  The stock market has hit record      │   ║
║  │  │        │  highs as investors...                │   ║
║  │  └────────┘                                        │   ║
║  │              Business Today • Sarah Johnson       │   ║
║  └───────────────────────────────────────────────────┘   ║
║                                                           ║
║  ┌───────────────────────────────────────────────────┐   ║
║  │  ┌────────┐  New Medical Breakthrough in         │   ║
║  │  │ [IMG]  │  Cancer Treatment                     🔖  │
║  │  │        │                                        │   ║
║  │  │ 80x80  │  Researchers announce a potential     │   ║
║  │  │        │  cure for certain...                  │   ║
║  │  └────────┘                                        │   ║
║  │              Health Today • Dr. Emily Brown       │   ║
║  └───────────────────────────────────────────────────┘   ║
║                                                           ║
║  ┌───────────────────────────────────────────────────┐   ║
║  │  ┌────────┐  Space Mission Successfully Lands    │   ║
║  │  │ [IMG]  │  on Mars                              🔖  │
║  │  │        │                                        │   ║
║  │  │ 80x80  │  A historic space mission has         │   ║
║  │  │        │  successfully landed...               │   ║
║  │  └────────┘                                        │   ║
║  │              Science Daily • Michael Chen         │   ║
║  └───────────────────────────────────────────────────┘   ║
║                                                           ║
╠═══════════════════════════════════════════════════════════╣
║     [📰 Headlines]    [📋 Sources]    [🔖 Saved]         ║
╚═══════════════════════════════════════════════════════════╝
```

## Component Breakdown

### Article Card
Each article card contains:

1. **Thumbnail Image** (Left)
   - Size: 80x80 dp
   - Rounded corners (4dp)
   - Loaded via Coil from URL

2. **Content Area** (Center)
   - **Title**: 
     - Typography: titleMedium
     - Max lines: 2
     - Overflow: Ellipsis
   
   - **Description**:
     - Typography: bodyMedium
     - Max lines: 2
     - Overflow: Ellipsis
     - Color: onSurfaceVariant
   
   - **Metadata Row**:
     - Source name (Primary color)
     - Bullet separator
     - Author name (onSurfaceVariant)
     - Typography: labelSmall

3. **Save Button** (Right)
   - Icon: Bookmark outline
   - Color: Primary
   - Action: Save article for later

### Bottom Navigation
- **3 Tabs**: Headlines (active), Sources, Saved
- **Icons**: 
  - Headlines: FeaturedPlayList
  - Sources: Source
  - Saved: Bookmark
- **Selection**: Highlighted tab shows current screen

## Material 3 Design Features

- **Cards**: Elevated with 2dp shadow
- **Corner Radius**: 8dp for cards, 4dp for images
- **Padding**: 16dp horizontal, 12dp inside cards
- **Spacing**: 8dp between cards
- **Typography**: Material 3 type scale
- **Colors**: Dynamic theming support (Android 12+)

## Interaction States

1. **Default**: Card at rest
2. **Hover/Press**: Ripple effect on card
3. **Click Article**: Navigate to webview
4. **Click Save**: Shows toast "Article saved"

## Responsive Layout

- Uses `LazyColumn` for efficient scrolling
- Adapts to different screen sizes
- Maintains 16:9 aspect ratio for images
- Text scales with system font size settings

## Loading States

1. **Loading**: Centered circular progress indicator
2. **Error**: Centered error message
3. **Empty**: "No articles available" message
4. **Success**: Article list as shown above
